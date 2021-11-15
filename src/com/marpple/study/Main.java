package com.marpple.study;

public class Main {

    public static void main(String[] args) {
        Config config;
        try {
            config = new Config(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }

        try {
            ApplicationRunner.run(config);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
