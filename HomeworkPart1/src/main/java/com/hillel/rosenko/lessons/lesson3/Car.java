package com.hillel.rosenko.lessons.lesson3;

public class Car {
        public String modelName;
        public Car(String modelName) {
            this.modelName = modelName;
        }

        public void start() {
            startElectricity();
            startCommand();
            startFuelSystem();
        }

        void stop() {
            stopElectricity();
            stopCommand();
            stopFuelSystem();
        }

        private void startElectricity() {
            System.out.println("startElectricity");
        }

        private void startCommand() {
        System.out.println("startCommand");
    }

        private void startFuelSystem() {
            System.out.println("startFuelSystem");
        }


        private void stopElectricity() {
            System.out.println("stopElectricity");
        }

        private void stopCommand() {
            System.out.println("stopCommand");
        }

        private void stopFuelSystem() {
        System.out.println("stopFuelSystem");
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

}
