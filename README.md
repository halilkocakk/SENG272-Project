# ISO 15939 Quality Measurement Tool

This project is a Java-based application developed to implement the ISO/IEC 15939 measurement process that I conducted as part of the SENG272 course.

## 🚀 Features

- Step-based wizard interface
- Profile creation
- Scenario selection (Education / Health)
- Metric planning and visualization
- Data collection and scoring
- Analysis with gap detection
- Dynamic UI with navigation controller

## 🧱 Architecture

The project follows a modular and layered design:

- **Model Layer**
    - Metric
    - QualityDimension
    - Scenario
    - MeasurementSession

- **UI Layer**
    - ProfilePanel
    - DefinePanel
    - PlanPanel
    - CollectPanel
    - AnalysePanel
    - StepIndicatorPanel

- **Controller**
    - WizardController

- **Main Frame**
    - MainFrame

## 🔄 Workflow

1. Enter user profile
2. Select quality type and scenario
3. View planned metrics
4. Enter measurement values
5. Analyze results and identify weakest dimension

## 🛠 Technologies Used

- Java
- Swing (GUI)
- OOP principles
- MVC-like structure

## ▶️ How to Run

1. Open project in IntelliJ IDEA
2. Run the `Main` class
