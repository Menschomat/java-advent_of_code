package de.menscho.space.utils;

public enum InputFileSize{
        SMALL("small.txt"),
        FULL("full.txt");

        public final String filename;

        InputFileSize(String filename) {
            this.filename = filename;
        }
    }