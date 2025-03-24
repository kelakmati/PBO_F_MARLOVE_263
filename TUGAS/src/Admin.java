class Admin {
    private String username = "Admin263";
    private String password = "password263";

    // Method untuk login admin
    public boolean login(String inputUser, String inputPass) {
        return inputUser.equals(username) && inputPass.equals(password);
    }
}