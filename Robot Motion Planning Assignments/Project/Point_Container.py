import math
from shapely.geometry import Point
from copy import copy

# Basic Unit container
class Point_Container():
    def __init__(self, x, y, direction = 0, velocity = 0):
        self.point = Point(x, y)
        self.x = x
        self.y = y

        self.direction = direction
        self.velocity = velocity

    def __copy__(self):
        return type(self)(self.x, self.y, self.direction, self.velocity)

    def get_pos(self):
        return (self.point.x, self.point.y)
    
    def set_pos(self, x, y):
        self.point = Point(x, y)
        self.x = x
        self.y = y

    # move point based on velocity and direction
    def apply_velocity(self):
        x_new = self.point.x + (self.velocity * math.cos(self.direction))
        y_new = self.point.y + (self.velocity * math.sin(self.direction))
        self.set_pos(x_new, y_new)

# Class for holding multiple points in a container
class Point_Container_List():
    def __init__(self, list = []):
        self.list = list
    def add_node(self, pc: Point_Container):
        self.list.append(pc)
    