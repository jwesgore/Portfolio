import math
from Point_Container import Point_Container
from shapely.geometry import Polygon, Point
from matplotlib.patches import Polygon as PPatch
from copy import copy

# used to create a shapely object from a Point Container
class Polygon_Builder():
    def __init__(self):
        return
    def build_polygon(pc:Point_Container, width, height):
        x, y = pc.get_pos()

        p2 = Point(x + width, y)
        p3 = Point(x + width, y + height)
        p4 = Point(x, y + height)
        return Polygon([pc.point, p2,p3,p4])

# holds an instance of a Point Container and a shapely polygon
class Polygon_Container():
    def __init__(self, pc: Point_Container, width, height, rebound=None):
        self.point_container = pc
        self.width = width
        self.height = height
        self.rebound = rebound

        self.polygon = Polygon_Builder.build_polygon(pc, width, height)

    def __copy__(self):
        return type(self)(copy(self.point_container), self.width, self.height)

    # returns position of point container
    def get_reference_position(self):
        return self.point_container.get_pos()

    def get_direction(self):
        return self.point_container.direction
    
    def get_velocity(self):
        return self.point_container.velocity

    def set_velocity(self, velocity):
        self.point_container.velocity = velocity

    def set_direction(self, direction):
        self.point_container.direction = direction
            
    def apply_velocity(self):
        self.point_container.apply_velocity()
        self.polygon = Polygon_Builder.build_polygon(self.point_container, self.width, self.height)

    def plot_lines(self):
        return 
    
    # returns a matplotlib patch
    def plot_patch(self):
        x, y = self.polygon.exterior.xy
        return PPatch([[x1,y1] for x1,y1 in zip(x,y)])

# List of Polygon Containers
class Polygon_Container_List():
    def __init__(self, list = []):
        self.list = list

    def add_polygon_container(self, pc: Polygon_Container):
        self.list.append(pc)

    # helper method to move all objects in list
    def apply_velocity(self):
        for ob in self.list:
            ob.apply_velocity()

    # returns all patches for containers in list
    def plot_patches(self, ax):
        for ob in self.list:
            ax.add_patch(ob.plot_patch())

    # checks for collision of a polygon with each polygon in list
    def check_map(self, polygon: Polygon):
        return [ob for ob in self.list if ob.polygon.intersects(polygon)]