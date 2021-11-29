package com.website.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

public class Test {
    public static void main(String[] args){
/*
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory factory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

//            BrandEntity brandEntity = new BrandEntity();
//            brandEntity.setBrandName("iPhone 7 Plus");
            UserEntity userEntity = new UserEntity();
            userEntity.setFullname("ff");
            userEntity.setId(3);
            session.save(userEntity);

            transaction.commit();

            session.close();
            factory.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
*/

        ///Khoi tao gia tri test
        HashMap<ProductEntity, Integer> map = new HashMap<ProductEntity, Integer>();
        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setProName("Ihone 11");
        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setProName("Ihone 9");
        ProductEntity productEntity3 = new ProductEntity();
        productEntity3.setProName("Ihone 50");
        map.put(productEntity1,10);
        map.put(productEntity2,5);
        map.put(productEntity3,100);


        // Khởi tạo ra một Set entries
        Set<Map.Entry<ProductEntity, Integer>> entries = map.entrySet();

        System.out.println("----- Before sorting, random order -----");
        for (Map.Entry<ProductEntity, Integer> entry : entries) {
            System.out.println(entry.getKey().getProName() + " ==>> " + entry.getValue());
        }

        // Tạo custom So sánh
        Comparator<Map.Entry<ProductEntity, Integer>> comparator = new Comparator<Map.Entry<ProductEntity, Integer>>() {
            @Override
            public int compare(Map.Entry<ProductEntity, Integer> e1, Map.Entry<ProductEntity, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        // Convert Set thành List
        List<Map.Entry<ProductEntity, Integer>> listEntries = new ArrayList<>(entries);

        // Sắp xếp List
        Collections.sort(listEntries, comparator);

        //Ham dao chuoii
        Collections.reverse(listEntries);
        for(int i = listEntries.size()-1; i>=0; i--){
            System.out.println(listEntries.get(i).getKey().getProName());
        }
    }
}
