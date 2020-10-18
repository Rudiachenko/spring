"# spring" 
+ Create a new project and link it to the GitHub  
+ Configure travis CI for this project. Instruction  
+ Implement UserService and UserDao  

    public interface UserService {  
        void add(User user);  
        List<User> listUsers();  
    }  
      
  
+ Create a Main class. Configure ApplicationContext  

+ In the Main class show how you are saving User into DB and reading him back  

+ Configure DataSource  

+ Understand the main concepts of Spring framework:  
ApplicationContext  
Bean  
Bean Autowiring  
Difference between @Bean and @Autowired and @Qualifier  