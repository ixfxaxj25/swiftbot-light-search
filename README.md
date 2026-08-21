# SwiftBot Light Search

A Java-based autonomous robotics project developed using the SwiftBot platform.

The program enables the SwiftBot to search for a light source using camera-based image processing. The captured image is analysed across different regions to determine the direction with the highest light intensity, allowing the robot to move towards the detected light source.

## Features

- Camera-based light detection
- RGB image analysis
- Light intensity comparison
- Autonomous robot movement
- Left, centre and right direction analysis
- Random movement when suitable light is not detected
- SwiftBot underlight indicators
- Movement tracking
- Distance tracking
- Execution logging
- X-button emergency stop
- Terminal-based user feedback

## Technologies

- Java
- SwiftBot API
- Raspberry Pi
- Java AWT
- BufferedImage
- Image processing
- Object-oriented programming

## How It Works

The SwiftBot captures an image using its camera and analyses the image to determine where the strongest light source is located.

The image is divided into three regions:

```text
+-------------------------------+
|       |        |              |
| LEFT  | CENTRE |    RIGHT     |
|       |        |              |
+-------------------------------+
```

The program calculates the light intensity of each region and compares the results.

The robot then selects the direction with the highest detected intensity.

```text
Camera Image
      |
      v
Analyse Image
      |
      v
+-----+------+------+
| Left|Centre|Right |
+-----+------+------+
      |
      v
Calculate Intensity
      |
      v
Find Strongest Direction
      |
      v
Move SwiftBot
      |
      v
Continue Searching
```

If a suitable light source is not detected, the SwiftBot moves in a different direction and continues searching.

## Project Structure

```text
swiftbot-light-search/
│
├── src/
│   ├── BotMoveAndLight.java
│   ├── PrintingTerminal.java
│   └── Task_6.java
│
├── README.md
└── .gitignore
```

### Task_6.java

Contains the main program logic for the SwiftBot light-search system, including image analysis, light detection and movement decisions.

### BotMoveAndLight.java

Contains reusable methods for controlling the SwiftBot's movement and underlights.

Examples include:

- Moving forward
- Moving left
- Moving right
- 90-degree turns
- Setting red underlights
- Setting purple underlights

### PrintingTerminal.java

Handles terminal messages and execution logging.

The program records information such as:

- Light intensity readings
- Number of light detections
- Robot movements
- Total distance travelled
- Execution duration

## Light Detection

The program uses RGB pixel values from the captured camera image to analyse light intensity.

The intensity of the different image regions is compared to determine which direction contains the strongest light source.

This allows the SwiftBot to make movement decisions based on its camera input rather than following a fixed route.

## Robot Movement

The project contains dedicated movement methods for controlling the SwiftBot.

For example:

```java
API.move(50, 50, 500);
```

The movement methods control the left and right motors to allow the robot to:

- Move forwards
- Turn left
- Turn right
- Perform larger turns
- Continue searching for light

## Logging

The program provides an execution log containing information about the robot's behaviour.

Example information includes:

```text
Overall Highest Intensity
Number Of Times Bot Detected Light
Movements Of The Bot
Total Distance Travelled
Duration Of Execution
```

This makes it possible to review the robot's behaviour after the search has finished.

## Objective

The objective of this project was to develop an autonomous SwiftBot capable of searching for a light source and moving towards it using camera-based image analysis.

The project combines:

- Robotics
- Java programming
- Image processing
- Algorithm design
- Autonomous decision-making
- Hardware control

## Skills Demonstrated

- Java programming
- Object-oriented programming
- Image processing
- RGB analysis
- Robotics programming
- Algorithm design
- Autonomous decision-making
- Hardware control
- Exception handling
- Debugging
- Testing

## Future Improvements

Potential improvements include:

- More advanced computer vision techniques
- Improved light detection in different environments
- Smoother robot movement
- More accurate distance tracking
- Obstacle detection and avoidance
- Real-time visualisation of light intensity
- Machine-learning-based light/object detection
- Improved navigation algorithms

## Author

**Ifaj Tajwar Khan**


