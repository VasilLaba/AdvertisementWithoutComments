package com.advertisement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Author : Vasil Laba.
 * Created : 07/10/2021.
 */
public class ApplicationDemo {

    public static void main(String[] args) {


//            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//            SessionFactory factory = meta.getSessionFactoryBuilder().build();
//            Session session = factory.openSession();
//            Transaction t = session.beginTransaction();
//
//            final Engine engine = new Engine();
//            engine.setModel("engine_model_03");
//            engine.setPower(12345);
//
//            session.save(engine);
//            t.commit();
//            System.out.println("successfully saved");
//            factory.close();
//            session.close();

//            final Engine result = engineDAO.read("engine_model_03");
//            System.out.println("Created : " + result);
//            System.out.println();
//
//            result.setPower(54321);
//            engineDAO.update(result);
//
//            final Engine update = engineDAO.read("engine_model_03");
//            System.out.println("Updated : " + update);
//            System.out.println();
//
//            engineDAO.delete(new Engine("engine_model_03", 54321));
//
//            System.out.println("Deleted(empty obj) : " + engineDAO.read("engine_model_03"));

    }
}