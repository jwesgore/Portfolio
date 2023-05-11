import matplotlib.pyplot as plt
from Point_Container import Point_Container, Point_Container_List
from Polygon_Container import Polygon_Container, Polygon_Container_List
from Robot import Robot
import math
from copy import copy

fig, ax = plt.subplots()
pcl = Polygon_Container_List()

##### Set robot parameters ######
rb_velocity = .3
rb_goal_distance = .5
rb_scan_distance = 2
rb_x = 0
rb_y = 0

rb_goal = Point_Container(10,10)
rb_point = Point_Container(rb_x,rb_y,0,rb_velocity)
rb_poly = Polygon_Container(rb_point, 1, 1)
robot = Robot(rb_poly, rb_goal, scan_distance=rb_scan_distance, goal_distance=rb_goal_distance)
robot.set_direction_auto()

###### Methods used for code organization and readability ######
def populate_list(): 

    point1 = Point_Container(2,1,math.pi/2,.1)
    poly1 = Polygon_Container(point1, 1, 1)

    point2 = Point_Container(5,5,0,0)
    poly2 = Polygon_Container(point2, 1, 1)

    point3 = Point_Container(.5,3.5,0,0)
    poly3 = Polygon_Container(point3, 1, 1)

    point4 = Point_Container(3,0,0,0)
    poly4 = Polygon_Container(point4, 1, 5)

    point5 = Point_Container(5,8,0,0)
    poly5 = Polygon_Container(point5, 7, 1)

    point6 = Point_Container(20,10,math.pi,.05)
    poly6 = Polygon_Container(point6, 3, 1)

    point7 = Point_Container(12,7,0,0)
    poly7 = Polygon_Container(point7, 1, 3)

    pcl.add_polygon_container(poly1)
    pcl.add_polygon_container(poly2)
    pcl.add_polygon_container(poly3)
    pcl.add_polygon_container(poly4)
    pcl.add_polygon_container(poly5)
    pcl.add_polygon_container(poly6)
    pcl.add_polygon_container(poly7)
def plot_all():

    ax.set_xlim(0,20)
    ax.set_ylim(0,20)
    
    # plot goal point
    plt.scatter(rb_goal.x, rb_goal.y, color='red')

    # plot the robot
    robot.plot_patch(ax)

    # plot objects
    pcl.plot_patches(ax)
    fig.canvas.draw()
    fig.canvas.flush_events()
    plt.pause(.01)
    ax.cla()
    for patch in ax.patches:
        patch.remove()


# populate pcl (def just used for organization)
populate_list()

# run program
while not robot.check_at_goal():
    
    # get which objects are in visible zone
    pcl.apply_velocity()
    in_zone = robot.check_area(pcl)

    # if objects are in visible zone
    if in_zone:
        # get valid angle for movement
        future = robot.future_collision(in_zone)
        if future is not None:
            robot.set_direction(future)
            robot.set_velocity(.1)
        else:
            robot.set_velocity(0) 

    else:
        robot.set_direction_auto()
        robot.set_velocity(rb_velocity)
  

    ##### MOVE ALL OBJECTS AND PLOT #####
    robot.apply_velocity()
    plot_all()

