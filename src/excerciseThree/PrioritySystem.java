package excerciseThree;

import java.util.PriorityQueue;

public class PrioritySystem {

    class Patient implements Comparable<Patient>{
        private String name;
        private int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Patient other){
            return Integer.compare(this.priority,other.priority);

        }
    }

    public class HospitalQueue {
        private PriorityQueue<Patient>priorityQueue;
        public HospitalQueue() {
            priorityQueue = new PriorityQueue<>();
        }

        public void addPatient(String name , int priority) {
            Patient newPatient = new Patient(name, priority);
            priorityQueue.offer(newPatient);
        }

        public String servePatients(){
            StringBuilder servedPatients = new StringBuilder();
            while(!priorityQueue.isEmpty()){
                Patient servedPatient = priorityQueue.poll();
                servedPatients.append(servedPatient.getName()).append( " (priority: ").append( servedPatient.getPriority()).append( ")\n");

            }
            return servedPatients.toString();
        }


        }
    }

