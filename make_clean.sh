#!/usr/bin/env bash
echo Removing all .class and temp files
find . -type f -name "*.class" -exec rm -f {} \;
find . -type f -name "*~" -exec rm -f {} \;
