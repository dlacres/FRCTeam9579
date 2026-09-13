# FRC Team 9579 - Tech Devils Robot Code (2027)

Official robot source code for the 2027 FIRST Robotics Competition (FRC) season. This repository contains the Java-based command-based robot program utilizing **WPILib**, and connects closely with our mechanical and electrical design workflows hosted on **Onshape**.

---

## 🤖 Robot Overview
* **Game:** [Game Name, e.g., CRESCENDO / REEFSCAPE]
* **Robot Name:** [Robot Name, e.g., Alloy / Overdrive]
* **Drivetrain:** [e.g., 4-Motor Swerve Drive / Tank Drive]
* **Key Mechanisms:** [e.g., Elevator, Intake, Shooter, Climber]
* **CAD Model:** [Link to Public/Team Onshape Document](https://cad.onshape.com)

---

## 🧰 Tech Stack & Tools
* **Language:** Java (JDK 17+)
* **Framework:** WPILib Command-Based Framework
* **Build System:** Gradle (via WPILib VS Code extension)
* **CAD & Design:** [Onshape](https://www.onshape.com) (utilizing [FIRST Library Apps](https://www.onshape.com/en/blog/first-robotics-cad-platform) for standard components)
* **Version Control:** GitLab

---

## 📂 Repository Structure
```text
src/main/java/frc/robot/
├── 📁 commands/       # Autonomous and teleoperated robot commands
├── 📁 subwoofers/     # Subsystem definitions (Drivetrain, Intake, etc.)
├── 📁 autos/          # Autonomous routines and trajectory generators
├── 📄 Constants.java  # Port numbers, PID gains, and physical dimensions
├── 📄 Robot.java      # Main robot lifecycle hooks
└── 📄 RobotContainer.java # Subsystem bindings and operator interface (OI) setup
```

---

## ⚙️ Development Setup

### Prerequisites
1. Install [VS Code](https://visualstudio.com).
2. Install the official **WPILib VS Code Extension** for your specific season year.
3. Ensure **Java JDK** (packaged with WPILib installer) is active on your system.

### Getting Started
1. Clone the repository:
   ```bash
   git clone https://gitlab.com/[your-team-group]/[year]-robot-code.git
   ```
2. Open the project folder in VS Code.
3. Press `Ctrl+Shift+P` (or `Cmd+Shift+P` on macOS) and run:
   > `WPILib: Refresh Gradle Dependencies`
4. Build the code to verify your environment:
   > `WPILib: Build Robot Code`

---

## 📐 CAD & Software Workflow (Onshape)
Our team uses [Onshape](https://www.onshape.com) for real-time collaborative mechanical design. 
* **Dimensions & Constants:** Physical measurements (wheel base, shooter angles, gear ratios) are pulled directly from the [Onshape Assembly](https://cad.onshape.com) and matched inside `Constants.java`.
* **Changes:** Coordinate with the mechanical sub-team before altering sensor placements or motor controllers in CAD that reflect back into code.

---

## 🚀 Deployment
1. Connect your computer to the robot network via **Ethernet** or **USB** to the roboRIO.
2. Open VS Code and run:
   > `WPILib: Deploy Robot Code`

---

## 🤝 Contributing
1. Create a descriptive feature/fix branch (e.g., `feature/elevator-pid`, `fix/auto-balance`).
2. Commit your changes atomically.
3. Push your branch to GitLab and open a **Merge Request (MR)** for code review by a programming lead.
