package com.thoughtworks.books.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    private String orderNumber;
    private String name;
    private String surname;
    private String contact;
    private String email;
    private String address;

    public Customer(String orderNumber, String name, String surname, String contact, String email, String address) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.surname = surname;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "orderNumber='" + orderNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (orderNumber != null ? !orderNumber.equals(customer.orderNumber) : customer.orderNumber != null)
            return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
        if (contact != null ? !contact.equals(customer.contact) : customer.contact != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;

    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
