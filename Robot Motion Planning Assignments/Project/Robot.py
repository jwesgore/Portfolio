from Polygon_Container import Polygon_Container, Polygon_Container_List
from Point_Container import Point_Container
from shapely.geometry import Polygon
from shapely import affinity
from scipy.stats import linregress
import math
import numpy as np
from copy import copy

class MyMath(): 
        
    def angle_to_point(p1:Point_Container, p2:Point_Container):
        offset = 0
        px1, py1 = p1.get_pos()
        px2, py2 = p2.get_pos()
        if px2 < px1: offset = math.pi
        try:
            return math.atan(linregress([px1, px2],[py1, py2])[0]) + offset
        except:
            return 0
        
class Robot():
    def __init__(self, polygon:Polygon_Container, goal:Point_Container, goal_distance = 2, scan_distance = 2):
        self.polygon_container = polygon
        self.scan_distance = scan_distance
        self.goal = goal
        self.goal_distance = goal_distance

    def __copy__(self):
        return type(self)(copy(self.polygon_container), copy(self.goal), self.goal_distance)

    ###### ROBOT CONTROLS AND INFO ########
    def set_direction(self, direction):
        self.polygon_container.set_direction(direction)

    def set_direction_auto(self):
        theta = MyMath.angle_to_point(self.polygon_container.point_container, self.goal)
        self.polygon_container.set_direction(theta)

    def get_direction(self):
        return self.polygon_container.get_direction()

    def apply_velocity(self):
        self.polygon_container.apply_velocity()

    def set_velocity(self, velocity):
        self.polygon_container.set_velocity(velocity)

    # undo previous movement
    def backtrack(self):
        dir = self.get_direction()
        self.set_direction(dir + math.pi)
        self.apply_velocity()
        self.set_direction(dir)

    # return matplotlib patch
    def plot_patch(self, ax):
        patch = self.polygon_container.plot_patch()
        patch.set_color('green')
        ax.add_patch(patch)

    ####### GET INFO FROM NEARBY OBJECT ######
    def is_stationary(self, object: Polygon_Container):
        if object.get_velocity() == 0:
            return True
        return False

    ####### CHECKS FOR LOCATION #######
    def check_out_of_bounds(self):
        x, y = self.polygon_container.get_reference_position()
        if x < 0 or y < 0:
            return True
        return False

    # check if obstacle is in the scannable area
    def check_area(self, map: Polygon_Container_List): 
        scaled_polygon = affinity.scale(self.polygon_container.polygon, xfact= self.scan_distance, yfact=self.scan_distance)
        return map.check_map(scaled_polygon)
    
    # check if obstacle and robot have collided
    def check_area_tight(self, map: Polygon_Container_List):
        for ob in map:
            if ob.polygon.intersects(self.polygon_container.polygon):
                return True
        return False

    # build projections of potential movement     
    def future_collision(self, map: Polygon_Container_List):

        # predefined angles
        fast_angles = (math.pi/6) * np.arange(12)
        cp_robo = copy(self)

        # check current angle
        cp_robo.apply_velocity()
        if not (cp_robo.check_area_tight(map) or cp_robo.check_out_of_bounds()):
            return cp_robo.get_direction()
        cp_robo.backtrack()

        # check fast angles
        for angle in fast_angles:
            cp_robo.set_direction(angle)
            cp_robo.apply_velocity()
            if cp_robo.check_area_tight(map) or cp_robo.check_out_of_bounds():
                cp_robo.backtrack()
                continue
            return angle
        
        # full scan
        
        return None

    def check_at_goal(self):
        p1 = self.polygon_container.get_reference_position()
        p2 = self.goal.get_pos()
        if math.dist(p1, p2) <= self.goal_distance:
            return True
        return False