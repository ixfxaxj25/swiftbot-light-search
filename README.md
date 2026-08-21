# SwiftBot Light Search

A Java-based autonomous robotics project developed using the SwiftBot platform.

The program enables the SwiftBot to search for a light source using camera-based image processing. The captured image is divided into three regions — left, centre and right — and the average light intensity of each region is calculated. The robot then uses this information to determine the direction of the strongest light source and moves accordingly.

## Features

- Camera-based light detection
- RGB image processing
- Three-direction light intensity analysis
- Autonomous robot movement
- Detection of the strongest light direction
- Random movement when a suitable light source is not detected
- SwiftBot underlight indicators
- Movement and distance tracking
- Execution logging
- X-button emergency stop
- User-friendly terminal output

## Technologies

- Java
- SwiftBot API
- Raspberry Pi
- Java AWT
- BufferedImage
- Image processing
- Object-oriented programming

## How It Works

The SwiftBot continuously captures images using its camera.

Each image is divided into three sections:

```text
+-------------------------------+
|       |        |              |
| LEFT  | CENTRE |    RIGHT     |
|       |        |              |
+-------------------------------+