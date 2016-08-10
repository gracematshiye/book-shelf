package com.thoughtworks.books.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String contact;
    private String email;
    private String address;

    public Customer(){}

    public Customer(String name, String surname, String contact, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
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
                ", id=" + id + '\'' +
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

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(name, customer.name)
                .append(surname, customer.surname)
                .append(contact, customer.contact)
                .append(email, customer.email)
                .append(address, customer.address)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(name)
                .append(surname)
                .append(contact)
                .append(email)
                .append(address)
                .toHashCode();
    }
}
