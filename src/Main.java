import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice ;
        ArrayList<Survey> surveys = new ArrayList<>();
        Survey s=new Survey();

        do {

            System.out.println("Welcome to Survey App");
            System.out.println("1 . Enter 1 to print a surveys result. ");
            System.out.println("2 . Enter 2 to find the most given answer in a survey.");
            System.out.println("3 . Enter 3 to take a survey .");
            System.out.println("4 . Enter 4 to print the answers given by a candidate.");
            System.out.println("5 . Enter 5 to find the candidate who has taken the most survey's.");
            System.out.println("6 . Enter 6 to add a question to a survey.");
            System.out.println("7 . Enter 7 to remove a question from a survey.");
            System.out.println("8 . Remove question which is answered by less than 50% of candidates.");
            System.out.println("9 . Enter 9 to create a survey.");
            System.out.println("10 . Exit program.");
            System.out.println("Choose a number:");
             choice = input.nextInt();




            switch (choice)
            {
                case 1:
                    surveyResult(surveys);
                    break;
                case 3:
                    takeSurvey(surveys);
                    break;
                case 6:
                    removequestion(surveys);
                    break;
                case 9:
                    createSurvey(surveys,s);
                    break;
                case 10:
                    break;
            }


        }while (choice!=10);

    }

    public static void createSurvey(ArrayList<Survey> surveys, Survey newSurvey){



        Scanner input = new Scanner(System.in);

        String title,topic,description;

        System.out.println("Give the survey's title");
         title=input.next();
        newSurvey.setTitle(title);

        System.out.println("Give the survey's description");
         description=input.next();
        newSurvey.setDescription(description);

        System.out.println("Give the survey's topic");
         topic=input.next();
        newSurvey.setTopic(topic);


        List  questions = new ArrayList<String>();
        int counter=0;
        String q;
        int qnr=surveyLength();
       while (counter<10){
           System.out.println("Give a new question");
           q=input.next();
           //validimi i unicitetit
           if(!questions.contains(q)) {
               questions.add(q);
               counter++;
           }
           else
               System.out.println("This question already exists!");

       }
        surveys.add(newSurvey);



    }
    //validimi i 10<questions>40
    public static int surveyLength(){
        Scanner input= new Scanner(System.in);
        int nr;
        System.out.println("How many questions will your survey contain?");
        nr=input.nextInt();

        while(nr<10 || nr>40){
            System.out.println("The number must be between 10 and 40");
            nr=input.nextInt();

        }

        return nr;
    }

    public static void takeSurvey(ArrayList<Survey> surveys) {
        String answer;
        User newUser= new User();
        ArrayList<User> users = new ArrayList<>();
        Map answers= new HashMap<ArrayList<String>,String>();
        Scanner input = new Scanner(System.in);
        for (Survey survey:surveys) {
            System.out.println(survey.getTitle());
        }
        String choise,name,lastname,email,phone;
        System.out.println("Enter the name of the survey:");
        choise=input.next();
        System.out.println("Enter your name");
        name=input.next();
        newUser.setFname(name);

        System.out.println("Enter your Last name");
        lastname=input.next();
        newUser.setFname(lastname);

        System.out.println("Enter your email");
        email=input.next();
        newUser.setFname(email);

        System.out.println("Enter your phone number");
        phone=input.next();
        newUser.setFname(phone);

        users.add(newUser);
        for (int i=0;i<surveys.size();i++){

                if((surveys.get(i).getTitle().toString())==choise){

                    for(int j=0; j< surveys.get(i).getQuestions().size();j++){
                        System.out.println(surveys.get(i).getQuestions().get(i));
                        answer=input.next();
                        answers.put(surveys.get(i).getQuestions().get(i),answer);
                    }
                }


        }


    }

    public static void surveyResult(ArrayList<Survey> surveys) {
        Scanner input=new Scanner(System.in);
        System.out.println("Give the survey name");
        String name=input.next();
        for (var s: surveys ) {
            if (s.getTitle()==name){
                System.out.println(s.getAnswers());
            }
        }


    }
    public static void removequestion(ArrayList<Survey> surveys){
        System.out.println("Give the name of survey and question");
        Scanner input=new Scanner(System.in);
        String surveyTitle, question;
        surveyTitle=input.next();
        question=input.next();
        for (Survey s:surveys) {
            if (s.getTitle()==surveyTitle){
                s.getQuestions().remove(question);
            }
        }



    }

}