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

## 📊 ISO/IEC 25023 Metric Reference

| ISO 25010 Characteristic | ISO 25023 Metric Name | Direction | Unit |
|---|---|---|---|
| Functional Suitability | Functional Completeness Ratio | Higher | % |
| Functional Suitability | Functional Correctness Ratio | Higher | % |
| Reliability | Availability Ratio | Higher | % |
| Reliability | Defect Density | Lower | defect/KLOC |
| Reliability | MTBF (Mean Time Between Failures) | Higher | hours |
| Performance Efficiency | Response Time | Lower | ms |
| Performance Efficiency | Throughput | Higher | req/s |
| Performance Efficiency | CPU Utilisation Ratio | Lower | % |
| Usability | Task Completion Rate | Higher | % |
| Usability | User Error Rate | Lower | % |
| Security | Security Test Coverage | Higher | % |
| Security | Vulnerability Count | Lower | count |
| Maintainability | Test Coverage Ratio | Higher | % |
| Maintainability | Cyclomatic Complexity (avg) | Lower | score |

## 🛠 Technologies Used

- Java
- Swing (GUI)
- OOP principles
- Layered architecture inspired by MVC

## ▶️ How to Run

1. Open project in IntelliJ IDEA
2. Run the `Main` class

