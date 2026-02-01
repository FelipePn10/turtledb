ANTLR_JAR ?= antlr-4.13.1-complete.jar
ANTLR_SRC = src/main/antlr
ANTLR_OUT = build/generated/antlr

GRAMMARS=$(shell find src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/drop/index/ -name "*.g4")

.PHONY: all generate build test clean

all: generate build test

generate: $(GRAMMARS)
	@echo "Generating ANTLR parsers..."
	java -jar antlr-4.13.1-complete.jar -visitor -no-listener $(GRAMMARS)

build:
	./gradlew build

test:
	./gradlew test

clean:
	./gradlew clean
	find src/main/java -name "*Parser.java"  -delete
	find src/main/java -name "*.interp" 	 -delete
	find src/main/java -name "*.tokens" 	 -delete
	find src/main/java -name "*Lexer.java"   -delete
	find src/main/java -name "*Visitor.java" -delete
