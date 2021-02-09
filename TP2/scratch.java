
package be.fnord.DefaultLogic;

import java.util.HashSet;
import java.util.LinkedList;

import a.e;
import be.fnord.util.logic.DefaultReasoner;
import be.fnord.util.logic.WFF;
import be.fnord.util.logic.defaultLogic.DefaultRule;
import be.fnord.util.logic.defaultLogic.RuleSet;
import be.fnord.util.logic.defaultLogic.WorldSet;

class tp2 {
    public static void exo6(){
        WorldSet myWorld = new WorldSet();
        myWorld.addFormula(a.e.EMPTY_EFFECT);
        myWorld.addFormula(" Chretien_libanais_x  -> Chretien_x ");
        myWorld.addFormula("( Melkit_x ->  (Chretien_libanais_x  & "+ a.e.NOT+"Maronite_x ))");
        myWorld.addFormula("( Melkit_x -> Arabe_x )");
        myWorld.addFormula("( Melkit_x -> "+ a.e.NOT+"parle_francais_x)");
        myWorld.addFormula("(Mohamed -> Melkit_x)");
        myWorld.addFormula("(Georges -> Maronite_x)");
        myWorld.addFormula("Georges -> Arabe_x");
        DefaultRule rulex = new DefaultRule();
        rulex.setPrerequisite("Mohamed");
        rulex.setJustificatoin("Maronite_x");
        rulex.setConsequence("Maronite_x");

        DefaultRule ruley = new DefaultRule();
        ruley.setPrerequisite("Mohamed");
        ruley.setJustificatoin("Melkit_x");
        ruley.setConsequence("Melkit_x");



        DefaultRule rule1 = new DefaultRule();
        rule1.setPrerequisite("Chretien_libanais_x");
        rule1.setJustificatoin("Maronite_x");
        rule1.setConsequence("Maronite_x");

        DefaultRule rule2 = new DefaultRule();
        rule2.setPrerequisite("Chretien_libanais_x");
        rule2.setJustificatoin(e.NOT+"Arabe_x");
        rule2.setConsequence(e.NOT+"Arabe_x");

        DefaultRule rule3 = new DefaultRule();
        rule3.setPrerequisite("libanais_x");
        rule3.setJustificatoin("parle_francais_x");
        rule3.setConsequence("parle_francais_x");


        RuleSet myRules = new RuleSet();
        myRules.addRule(rule1);
        myRules.addRule(rule2);
        myRules.addRule(rule3);
		/*myRules.addRule(rulex);
		myRules.addRule(ruley);*/

        //RuleSet myRules = new RuleSet();
        WFF World =new WFF(myWorld.getWorld());
        LinkedList<String> consequences =myRules.getAllConsequences(new WFF(myWorld.getWorld()));
        LinkedList<String> extensionss = myRules.generateExtensions(consequences, World);

        DefaultReasoner loader = new DefaultReasoner(myWorld, myRules);

        HashSet<String> extensions = loader.getPossibleScenarios();
        extensions = loader.getPossibleScenarios();

        a.e.println("Given the world: \n\t" + myWorld.toString()
                + "\n And the rules \n\t" + myRules.toString());
        for (String c : extensions) {
            a.e.println("\t Ext: Th(W U (" + c + "))");
            // Added closure operator
            a.e.incIndent();
            WFF world_and_ext = new WFF("(( " + myWorld.getWorld() + " ) & ("
                    + c + "))");
            a.e.println("= " + world_and_ext.getClosure());
            a.e.decIndent();

        }
    }


        public static void exo5(){
            DefaultRule d1 = new DefaultRule();
            d1.setPrerequisite("A");
            d1.setJustificatoin("B");
            d1.setConsequence("C");
            /************************/
            DefaultRule d2 = new DefaultRule();
            d2.setPrerequisite("A");
            d2.setJustificatoin(e.NOT+"C");
            d2.setConsequence("D");
            /************************/
            RuleSet myRules = new RuleSet();
            myRules.addRule(d1);
            myRules.addRule(d2);
            /*******************/
            WorldSet W1= new WorldSet();
            W1.addFormula(e.NOT+"A");
            /************************/
            WorldSet W2= new WorldSet();

            W2.addFormula(e.NOT+"B");
            W2.addFormula("A");
            /************************/
            WorldSet W3= new WorldSet();
            W3.addFormula("A");
            W3.addFormula("("+e.NOT+"B"+ e.AND+"C)");
            /***********************/


            /****************execution World1************/
            try {
                a.e.println("world 1\n\n\n");
                DefaultReasoner l = new DefaultReasoner(W1, myRules);
                HashSet<String> extensions = l.getPossibleScenarios();
                a.e.println("Given the world: \n\t" + W1.toString()
                        + "\n And the rules \n\t" + myRules.toString());
                for (String c : extensions) {
                    a.e.println("\t Ext: Th(W U (" + c + "))");
                    // Added closure operator
                    a.e.incIndent();
                    WFF world_and_ext = new WFF("(( " + W1.getWorld() + " ) & ("
                            + c + "))");
                    a.e.println("= " + world_and_ext.getClosure());
                    a.e.decIndent();
                }
                a.e.println("");
            }catch(Exception e){

            }
            /****************execution World2************/
            try {
                a.e.println("world 2\n\n\n");
                DefaultReasoner l = new DefaultReasoner(W2, myRules);
                HashSet<String> extensions = l.getPossibleScenarios();
                a.e.println("Given the world: \n\t" + W2.toString()
                        + "\n And the rules \n\t" + myRules.toString());
                for (String c : extensions) {
                    a.e.println("\t Ext: Th(W U (" + c + "))");
                    // Added closure operator
                    a.e.incIndent();
                    WFF world_and_ext = new WFF("(( " + W2.getWorld() + " ) & ("
                            + c + "))");
                    a.e.println("= " + world_and_ext.getClosure());
                    a.e.decIndent();
                }
                a.e.println("");
            }catch(Exception e){
            }
            /****************execution World3************/
            try {
                a.e.println("world 3\n\n\n");
                DefaultReasoner l = new DefaultReasoner(W3, myRules);

                HashSet<String> extensions = l.getPossibleScenarios();


                a.e.println("Given the world: \n\t" + W3.toString()
                        + "\n And the rules \n\t" + myRules.toString());
                for (String c : extensions) {
                    a.e.println("\t Ext: Th(W U (" + c + "))");
                    // Added closure operator
                    a.e.incIndent();
                    WFF world_and_ext = new WFF("(( " + W3.getWorld() + " ) & ("
                            + c + "))");
                    a.e.println("= " + world_and_ext.getClosure());
                    a.e.decIndent();

                }
                a.e.println("");

            }catch(Exception e){

            }


        }
        public static void main(String[] args) {


        exo5();
    }
}
