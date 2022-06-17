<!--[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/dragonempire96/DnD-Currency-Manager/Gradle%20Check?label=checks)]([https://github.com/dragonempire96/DnD-Currency-Manager/issues](https://github.com/dragonempire96/DnD-Currency-Manager/actions))-->
[![GitHub issues](https://img.shields.io/github/issues/dragonempire96/DnD-Currency-Manager)](https://github.com/dragonempire96/DnD-Currency-Manager/issues)
[![GitHub license](https://img.shields.io/github/license/dragonempire96/DnD-Currency-Manager)](https://github.com/dragonempire96/DnD-Currency-Manager/blob/main/LICENSE)

# DnD-Currency-Manager

## What is it?
It is a program that informs a player how much money his character currently has and to manage it. Besides, he can buy and sell items so that he can update the money automatically.

## How do I use it?
First you have to create a shadow jar with the imported gradle plugin via tasks > shadow > shadowJar.

After that you direct your terminal to the directory of the shadow jar (it's in dnd-currency/build/libs by default) and use the DnD-Currency-Manager with the following commands.

## Development

This is a gradle project. Check out the repository and configure it in your IDE as a gradle project. We are using the latest LTS JDK, which is currently version 17.

### How do I contribute?

First, please make sure to follow the [Code of Conduct](https://github.com/dragonempire96/DnD-Currency-Manager/blob/main/CODE_OF_CONDUCT.md) if you want to contribute.

Check for [open issues](https://github.com/hhu-propra1/time-tracker/issues), select one you want to solve, [fork](https://github.com/dragonempire96/DnD-Currency-Manager/fork) the project, fix the issue and send a pull request!

You can also create your own issues and tell us what needs to be fixed or added.

### Distributing the application

Build a jar with this command:

    ./gradlew shadowJar

Native builds can be achieved using this command:

    ./gradlew nativeBuild

Keep in mind, that you need a valid graalvm-installation on your machine for this command.

## License
This project uses the [MIT License](https://github.com/hhu-propra1/time-tracker/blob/main/LICENSE).