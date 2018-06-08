package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
       // modelData = new ModelData();
        List<User> list = new ArrayList<>();
        list.add(new User("A", 1, 1));
        list.add(new User("B", 1, 1));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }
    //    public static void main(String[] args) {
//        FakeModel fakeModel = new FakeModel();
//        fakeModel.loadUsers();
//        System.out.println(fakeModel.getModelData().getUsers());
//    }
}
