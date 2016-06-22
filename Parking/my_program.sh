#!/bin/bash
javac -d . src/com/gojek/parking/*

    java com/gojek/parking/ParkingApp $1
