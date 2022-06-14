# Makefile
run-dist: # запуск исполняемого файла
	./build/install/app/bin/app

project-build: #сборка проекта
	gradle clean build

lint-main: #проверка на стандарт кодирования Main
	gradle checkstyleMain

lint-test: #сборка проекта
	gradle checkstyleTest

run-test: #запуск тестов
	gradle test