This program is comprised of several files

Point Container ---> Custom Class which holds points
Polygon Container -> Custom Class which hold polygons built off Point Containers
Robot -------------> Custom Class which holds a polygon container with extra methods for controlling the Robot
Main --------------> Driver code for the program

Several libraries are used in the creation of this projects as will

Matplotlib -----> Used for creating visual
NumPy ----------> Used for simple calculations
Shapely --------> Used for collision detection
SciPy ----------> Used for linear regression
Math -----------> Used mainly for trigonometric functions

Pip can be used to install required libraries
* if matplotlib is install, it is likely that numpy and scipy are already installed *

Matplotlib -----> pip install matplotlib
NumPy ----------> pip install numpy
Shapely --------> pip install shapely
SciPy ----------> pip install scipy 

To run code, compile code in this order
1. Point Container
2. Polygon Container
3. Robot
4. Main

Once 1-3 are compiled, changes can be made to Main without the need to recompile them