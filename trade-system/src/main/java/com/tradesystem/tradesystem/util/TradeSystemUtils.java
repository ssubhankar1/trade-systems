package com.tradesystem.tradesystem.util;

import com.tradesystem.tradesystem.model.TradeStoreDTO;
import com.tradesystem.tradesystem.persistence.entity.TradeStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class TradeSystemUtils {

    private static Logger logger = LoggerFactory.getLogger(TradeSystemUtils.class);

    public  static Object populateFields(Object objectOfClass,Class targetObjectClass){
           // throws IntrospectionException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object targetObject =null;
        try{
            targetObject = targetObjectClass.newInstance();
            BeanUtils.copyProperties(targetObject, objectOfClass);
            Class fromClass = objectOfClass.getClass();// class wherefrom variables will be read
            BeanInfo targetClassIfo = Introspector
                    .getBeanInfo(targetObjectClass);
            //objectOfClass = targetClass.newInstance();
            PropertyDescriptor[] propertyDescriptors = targetClassIfo.getPropertyDescriptors();
            PropertyUtils propertyUtils = new PropertyUtils();
            //BeanUtils.

            for (PropertyDescriptor descriptor : propertyDescriptors) {// target class properties inr
                Object value = propertyUtils.getProperty(fromClass, descriptor.getDisplayName());
                System.out.println("Printing value" +value);
                String property = descriptor.getDisplayName();// var name
                if (!"class".equals(property) && null!=value){
                    descriptor.getWriteMethod().invoke(targetObject,value);
                }

                //if(property.equals(variableName)) {
              /*  String setter = descriptor.getWriteMethod().getName();
                Class parameterType = descriptor.getPropertyType();
                Method setterMethod = targetClass.getDeclaredMethod(setter, parameterType); //Using Method Reflection
                setterMethod.invoke(objectOfClass, valueToBeSet);*/
                //}
            }
        }catch(Exception exception){
            logger.error("Exception while parsing fields "+exception);
        }
        return targetObject;
    }

    public static void main(String[] args) {
        TradeStore tradeStoreDTO = new TradeStore();
        tradeStoreDTO.setTradeId("T3");
        tradeStoreDTO.setBookingId("B3");
        tradeStoreDTO.setVersion(4);
        tradeStoreDTO.setCounterPartyId("Cp-3");
        tradeStoreDTO.setCreatedDate(new Date());
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        dt = c.getTime();
        tradeStoreDTO.setMaturityDate(dt);
        tradeStoreDTO.setExpiredFlag("N");
        TradeStoreDTO dto = new TradeStoreDTO();
        BeanUtils.copyProperties(tradeStoreDTO,dto);
        System.out.println("DTO "+dto);
        //TradeSystemUtils.populateFields(tradeStoreDTO,TradeStoreDTO.class);
    }
}
