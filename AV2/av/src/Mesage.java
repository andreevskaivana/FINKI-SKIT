class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }

    public String salute(){
        message="Hi "+message;
        System.out.println(message);
        return message;
    }

    public String bye(){
        message="Goodbye";
        return message;
    }
}