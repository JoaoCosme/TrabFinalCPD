package service;

import model.User;

public class UserHashTable extends hashTable{

    public UserHashTable(int hashtablesize) {
        super(hashtablesize);
    }

    public void add(User User){
        int indexToAdd = hashValue(User.getId());
        super.add(User,indexToAdd);
    }

    public User getUser(int userId){
        int indexProcurado = hashValue(userId);
        return (User) super.getItem(new User(userId),indexProcurado);
    } 
}
