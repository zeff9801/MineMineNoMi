## Fixes:

- Custom ForgeGradle fork is used ([this one](https://github.com/juanmuscaria/ForgeGradle)). Ensures compatibility with Gradle 5.+, fixes some repository references and does a couple obscure manipulations with `.classpath` file for Eclipse projects to ensure they won't break again;
- Custom maven repository is used for locating all basic dependencies ([this one](https://github.com/juanmuscaria/maven)). Since Forge guys keep making breaking changes on their side without caring about old Minecraft versions, this is a much more reliable option than trying to chase their ever-shifting repos;
- Buildscript now enforces Java 8 compliance and UTF-8 encoding for all files.

## Building Features:

- Gradle wrapper 5.6.4 is used by default;
- Buildscript contains tasks for generating `dev` and `sources` artifacts for your mod, as well as ensures they will be generated alongside main jar when executing `gradlew build`;
- All data in `mcmod.info` file is filled when actually building a mod. use `gradle.properties` file for declaring custom properties used by `build.gradle`;
- Illustration of how to add another mod to project dependencies, in a form of local file.

## Short Setup Guide:

If you ended up here, I assume you are already familiar with how to setup basic Forge workspace, so I won't be covering it all in great detail. Only the most important steps, just in case you forgot something:

1. Ensure you have JDK 8 installed (not just JRE), and `JAVA_HOME` environment variable is set in your system, pointing to that JDK;
2. Download this repository contents, create folder for your mod-specific workspace and unpack those contents into that folder;
3. Open up a command line in that folder, and execure `gradlew setupDecompWorkspace`. Once its done, run IDE-specific command to generate project for your IDE; either `gradlew eclipse` or `gradlew idea`;
4. In case you use Eclipse, don't forget that you need to open your workspace by choosing `eclipse` folder within your mod-specific folder as workspace location. In case you use Idea... I dunno, you know better what to do;
5. Use `gradlew build` whenever you need to build a `.jar` with your mod. It will end up being in `build/libs` directory within your mod-specific workspace folder.