# ISO/IEC 25010 & 25023 Software Quality Evaluation Tool

This project is a Java Swing-based software quality evaluation system developed for SENG 272 Lab Assignment 2.

The system evaluates software products using ISO/IEC 25010 quality characteristics and ISO/IEC 25023 measurable metrics.

## 📘 Course Information

- Course: SENG 272
- Student: Halil İbrahim Koçak
- Student ID: 202328039

## 🚀 Features

- Step-based wizard interface
- Profile creation
- Scenario selection (Education / Health)
- Metric planning and visualization
- Data collection and scoring
- Analysis with gap detection
- Dynamic UI navigation using CardLayout and WizardController
- ISO/IEC 25010-based quality score calculations
- Swing-based GUI workflow

## 🧱 Architecture

The project follows a modular and layered design:

- **Model Layer**
    - Metric
    - QualityDimension
    - Scenario
    - MeasurementSession
    - ScenarioRepository

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

## 📊 Quality Metrics Used in the Project

| Quality Characteristic | Metric Name | Direction | Unit |
|---|---|---|---|
| Usability | SUS Score | Higher | points |
| Usability | Onboarding Time | Lower | min |
| Performance Efficiency | Video Start Time | Lower | sec |
| Performance Efficiency | Concurrent Exams | Higher | users |
| Accessibility | WCAG Compliance | Higher | % |
| Accessibility | Screen Reader Score | Higher | % |
| Reliability | Uptime | Higher | % |
| Reliability | MTTR | Lower | min |
| Functional Suitability | Feature Completion | Higher | % |
| Functional Suitability | Assignment Submit Rate | Higher | % |

## 🛠 Technologies Used

- Java
- Swing (GUI)
- OOP principles
- Layered architecture inspired by MVC

## ▶️ How to Run

1. Open project in IntelliJ IDEA
2. Run the `Main` class

