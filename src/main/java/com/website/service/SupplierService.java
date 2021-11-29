package com.website.service;

import com.website.dao.SupplierDAO;
import com.website.models.SupplierEntity;

import java.util.List;

public class SupplierService {
    SupplierDAO supplierDAO = new SupplierDAO();
    public List<SupplierEntity> findAll() {
        return supplierDAO.findAll();
    }
    public void save(SupplierEntity supplier) {
        supplierDAO.save(supplier);
    }
    public SupplierEntity findById(Integer id) {
        return supplierDAO.findById(id);
    }
    public SupplierEntity update(SupplierEntity supplier) {
        return supplierDAO.update(supplier);
    }
    public int delete(Integer id) {
        SupplierEntity supplier = findById(id);
        supplier.setStatus(0);
        SupplierEntity deletedSupplier =update(supplier);
        if (deletedSupplier ==null) {
            return 0;
        } else {
            return 1;
        }
    }

}
