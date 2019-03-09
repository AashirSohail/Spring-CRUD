package aashir.spring;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Person Class
 * Contains attributes such as name, fatherName etc
 * Contains Getters and Setters
 * Entity Class mapped on table "person"
 */
@Entity
@Table( name = "Persons" )
public class person {

    /*
     * Attributes
     * Primary key: id
     */
        @Id
        int id;
        String name;
        String fatherName;
        String organization;
        String mobile;
        String username;
        String password;

    public person(){

    }

        //Constructor
    public person(int id, String name, String fatherName, String organization, String mobile, String username, String password) {
        this.id = id;
    	this.name = name;
        this.fatherName = fatherName;
        this.organization = organization;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
    }


    /*
         * Getters and Setters
         */
        public int getId() { return id; }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}