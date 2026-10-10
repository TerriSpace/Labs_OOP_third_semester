class CommonUser {

    private String username;
    private String email;
    private String password;

    public CommonUser(String username, String email, String password){

        this.username = username;
        this.email = email;
        this.password = password;

    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public void setUsername(String new_username){
        this.username = new_username;
    }
    public void setEmail(String new_email){
        this.email = new_email;
    }
    public void setPassword(String new_password){
        this.password = new_password;
    }

    public void login(){
        System.out.println("User: " + username + " sucsessfully login");
    }
    public void logout(){
        System.out.println("User: " + username + " sucsessfully logout");
    }
    public void updateUsername(String email, String password, String new_username){
        this.username = new_username;
        System.out.println("New username: " + username);
    }

}

class SystemAdministrator extends CommonUser {

    private String adminLevel;
    private int managedServersCount;
    private String department;

    public SystemAdministrator(String username, String email, String password, String adminLevel, int managedServersCount, String department) {
        super(username, email, password);
        this.adminLevel = adminLevel;
        this.managedServersCount = managedServersCount;
        this.department = department;
    }

    public String getAdminLevel(){
        return adminLevel;
    }
    public int getManagedServersCount(){
        return managedServersCount;
    }
    public String getDepartment(){ 
        return department;
    }


    public void setAdminLevel(String adminLevel){
        this.adminLevel = adminLevel;
    }
    public void setManagedServersCount(int managedServersCount){
        this.managedServersCount = managedServersCount;
    }
    public void setDepartment(String department){
        this.department = department;
    }


    public void restartServer(String serverName) {
        System.out.println("Administrator " + getUsername() + " restarts server: " + serverName);
    }
    public void installSoftware(String softwareName) {
        System.out.println("Installing software '" + softwareName + "' on servers in " + department);
    }
    public void blockUser(String targetUsername) {
        System.out.println("User " + targetUsername + " blocked by administrator " + getUsername());
    }
}


class DatabaseAdministrator extends SystemAdministrator {

    private String databaseType;
    private String backupSchedule;
    private int maxConnections;

    public DatabaseAdministrator(String username, String email, String password, String adminLevel, int managedServersCount, String department, String databaseType, String backupSchedule, int maxConnections) {
        super(username, email, password, adminLevel, managedServersCount, department);
        this.databaseType = databaseType;
        this.backupSchedule = backupSchedule;
        this.maxConnections = maxConnections;
    }


    public String getDatabaseType(){
        return databaseType;
    }
    public String getBackupSchedule(){
        return backupSchedule;
    }
    public int getMaxConnections(){
        return maxConnections;
    }


    public void setDatabaseType(String databaseType){
        this.databaseType = databaseType;
    }
    public void setBackupSchedule(String backupSchedule){
        this.backupSchedule = backupSchedule;
    }
    public void setMaxConnections(int maxConnections){
        this.maxConnections = maxConnections;
    }


    public void createBackup() {
        System.out.println("Creating backup for " + databaseType + " on schedule: " + backupSchedule);
    }
    public void optimizeQuery(String query) {
        System.out.println("Optimizing query: " + query);
    }
    public void increaseMaxConnections(int amount) {
        this.maxConnections += amount;
        System.out.println("Max connections increased to " + maxConnections);
    }
}



public class Main {
    public static void main(String[] args) {
        
        CommonUser user = new CommonUser("ivan", "ivan@mail.ru", "qwerty");
        user.login();
        user.updateUsername("ivan@mail.ru", "qwerty", "ivan_new");
        user.logout();

        SystemAdministrator sysAdmin = new SystemAdministrator(
                "super_admin", "admin@sys.local", "hash123",
                "Senior", 15, "IT Department"
        );
        sysAdmin.login();
        sysAdmin.restartServer("Web-Server-01");
        sysAdmin.installSoftware("Antivirus");
        sysAdmin.blockUser("hacker123");
        sysAdmin.logout();

        DatabaseAdministrator dbAdmin = new DatabaseAdministrator(
                "db_guru", "db@sys.local", "hash456",
                "Middle", 3, "IT Department",
                "PostgreSQL", "Every day at 03:00", 100
        );
        dbAdmin.login();
        dbAdmin.restartServer("DB-Server-01");
        dbAdmin.createBackup();
        dbAdmin.increaseMaxConnections(50);
    }
}