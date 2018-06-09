package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ItemDao itemDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1=new Product("długopis");
        Product product2=new Product("zeszyt");
        Product product3=new Product("ołówek");

        Item item1=new Item(product1,new BigDecimal(1.2),3);
        Item item2=new Item(product1,new BigDecimal(1.4),4);
        Item item3=new Item(product2,new BigDecimal(3.5),2);
        Item item4=new Item(product3,new BigDecimal(0.7),1);

        Invoice invoice=new Invoice("P32/2018");

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);


        //When
        invoiceDao.save(invoice);
        int invoiceId=invoice.getId();
        int product1Id=product1.getId();
        int product2Id=product2.getId();
        int product3Id=product3.getId();

        //Then
        Assert.assertNotEquals(0, invoiceId);
        //CleanUp

        try {
            invoiceDao.deleteById(invoiceId);
            productDao.deleteById(product1Id);
            productDao.deleteById(product2Id);
            productDao.deleteById(product3Id);
        }
        catch (Exception e)
        {

        }

    }
}
