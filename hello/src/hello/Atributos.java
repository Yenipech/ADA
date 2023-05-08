package hello;

import java.io.Serializable;

public class Atributos implements Serializable {
    	private static final long serialVersionUID = 1L;
        private String atributo1;
        private String atributo2;
        private String atributo3;

        public Atributos(String atributo1, String atributo2, String atributo3) {
            this.atributo1 = atributo1;
            this.atributo2 = atributo2;
            this.atributo3 = atributo3;
        }

        public String getAtributo1() {
            return atributo1;
        }

        public void setAtributo1(String atributo1) {
            this.atributo1 = atributo1;
        }

        public String getAtributo2() {
            return atributo2;
        }

        public void setAtributo2(String atributo2) {
            this.atributo2 = atributo2;
        }

        public String getAtributo3() {
            return atributo3;
        }

        public void setAtributo3(String atributo3) {
            this.atributo3 = atributo3;
        }

        @Override
        public String toString() {
            return "Atributo 1: " + getAtributo1() + "\nAtributo 2: " + getAtributo2() + "\nAtributo 3: " + getAtributo3();
        }
    }



