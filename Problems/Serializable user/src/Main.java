import java.io.Serializable;

class User implements Serializable {
    public static final long serialVersionUID = 3L;
    String name;
    transient String password;
}
