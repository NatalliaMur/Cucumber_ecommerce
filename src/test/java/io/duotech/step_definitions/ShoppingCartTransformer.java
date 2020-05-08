package io.duotech.step_definitions;

import java.util.Locale;
import java.util.Map;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import io.duotech.beans.ShoppingCart;

public class ShoppingCartTransformer {
	
	 public Locale locale() {
	        return Locale.ENGLISH;
	    }
	    public void configureTypeRegistry(TypeRegistry typeRegistry) {
	        typeRegistry.defineDataTableType(new DataTableType(ShoppingCart.class,
	                       new TableEntryTransformer<ShoppingCart>() {
	                    
	            @Override
	            
	            public ShoppingCart transform(Map<String, String> row) throws Throwable{
	                          
	            	String description = row.get("Description"); 
	            	String unitPrace = row.get("Unit price");   
	            	String quantity = row.get("Quantity");    
	            	String priceBefore = row.get("Product Total"); 
	            	String priceAfter = row.get("Total After Fees");  
	                           
	                            return new ShoppingCart(description, unitPrace, quantity, priceBefore, priceAfter); 
	                        }
	                    }));
	    }

}
