pluginManagement {
	repositories {
//		maven { url = uri("https://repo.spring.io/milestone") }
//		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
	}
}
rootProject.name = "board"
include("board-boot")
include("board-entity")
include("board-api")
include("board-core")
