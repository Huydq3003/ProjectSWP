/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.product;

/**
 *
 * @author huy
 */
public class ProductError {
    
    private String nameError;
    private String materialError;
    private String widthError;
    private String heightError;
    private String depthError;
    private String styleError;
    private Float estimatePriceErr;
    private Float actualPriceErr;
    private int quantityError;

    public ProductError(String nameError, String materialError, String widthError, String heightError, String depthError, String styleError, Float estimatePriceErr, Float actualPriceErr, int quantityError) {
        this.nameError = nameError;
        this.materialError = materialError;
        this.widthError = widthError;
        this.heightError = heightError;
        this.depthError = depthError;
        this.styleError = styleError;
        this.estimatePriceErr = estimatePriceErr;
        this.actualPriceErr = actualPriceErr;
        this.quantityError = quantityError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getMaterialError() {
        return materialError;
    }

    public void setMaterialError(String materialError) {
        this.materialError = materialError;
    }

    public String getWidthError() {
        return widthError;
    }

    public void setWidthError(String widthError) {
        this.widthError = widthError;
    }

    public String getHeightError() {
        return heightError;
    }

    public void setHeightError(String heightError) {
        this.heightError = heightError;
    }

    public String getDepthError() {
        return depthError;
    }

    public void setDepthError(String depthError) {
        this.depthError = depthError;
    }

    public String getStyleError() {
        return styleError;
    }

    public void setStyleError(String styleError) {
        this.styleError = styleError;
    }

    public Float getEstimatePriceErr() {
        return estimatePriceErr;
    }

    public void setEstimatePriceErr(Float estimatePriceErr) {
        this.estimatePriceErr = estimatePriceErr;
    }

    public Float getActualPriceErr() {
        return actualPriceErr;
    }

    public void setActualPriceErr(Float actualPriceErr) {
        this.actualPriceErr = actualPriceErr;
    }

    public int getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(int quantityError) {
        this.quantityError = quantityError;
    }
    
    
}
