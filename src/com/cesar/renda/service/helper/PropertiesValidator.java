package com.cesar.renda.service.helper;

import java.util.ArrayList;
import java.util.List;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesValidator {

    public PropertiesValidator() {
        errors = new ArrayList<String>();
    }

//    public PropertiesValidator(ObjectBean obj) {
//        errors = new ArrayList<String>();
//        this.obj = obj;
//    }
//
//    public PropertiesValidator setContextProperties(Map<String, ModelPropertyBean> properties) {
//        this.properties = properties;
//        return this;
//    }
    public boolean isValid() {
        return errors.isEmpty();
    }

    public PropertiesValidator validateProperties(Object o) {
        
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
            for (PropertyDescriptor pDesc : beanInfo.getPropertyDescriptors()) {
                String pName = pDesc.getName();
                
                System.out.println("Nome : "+pName);
                Object value = pDesc.getReadMethod().invoke(o);
                System.out.println("Value : "+value);
            }
            return this;
        } catch (InvocationTargetException | IntrospectionException | IllegalAccessException | IllegalArgumentException ex) {
            Logger.getLogger(PropertiesValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    
//
////    public PropertiesValidator validateProperty(came) {
////        ModelPropertyBean property = properties.get(propertyName);
////        Object value = obj.getProperty(propertyName);
////        String strVal = (value == null) ? null : String.valueOf(value);
////        boolean res = true;
////        if (property.isRequired() && !StringUtils.hasText(strVal) && !property.getType().equalsIgnoreCase(BOOLEAN_PROPERTY)) {
////            errors.add(SpringAppContextUtil.getMessage("validation.mandatory_error", propertyName));
////            res = false;
////        } else if (StringUtils.hasText(strVal) || property.getType().equalsIgnoreCase(BOOLEAN_PROPERTY)) {
////            String pattern = property.getPattern();
////            if (StringUtils.hasText(pattern)) {
////                res = validatePattern(propertyName, strVal, pattern);
////            }
////            if (property.getType().equalsIgnoreCase(LONG_PROPERTY)) {
////                res = validateLong(property, propertyName, value);
////            } else if (property.getType().equalsIgnoreCase(INTEGER_PROPERTY)) {
////                res = validateInteger(property, propertyName, value);
////            } else if (property.getType().equalsIgnoreCase(DECIMAL_PROPERTY)) {
////                res = validateDecimal(property, propertyName, value);
////            } else if (property.getType().equalsIgnoreCase(DATE_PROPERTY)) {
////                res = validateDate(property, propertyName, value);
////            } else if (property.getType().equalsIgnoreCase(BOOLEAN_PROPERTY)) {
////                res = validateBoolean(property, propertyName, value);
////            } else {
////                res = validateText(property, propertyName, strVal);
////            }
////        }
////        if (res) {
////            String validationStr = property.getValidation();
////            if (StringUtils.hasText(validationStr)) {
////                ExpressionParser parser = new SpelExpressionParser();
////                res = parser.parseExpression("validationStr").getValue(Boolean.class);
////            }
////        }
////        return this;
////    }
//
//    public List<String> getErrors() {
//        return errors;
//    }
//
//    private boolean validatePattern(String propertyName, String strVal, String pattern) {
//        if (pattern.startsWith("/")) {
//            pattern = pattern.replaceFirst("/", "\"");
//        }
//        if (!Pattern.matches(pattern, strVal)) {
//            errors.add(SpringAppContextUtil.getMessage("validation.pattern_error", propertyName, strVal));
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateText(ModelPropertyBean property, String name, String value) {
//        String min = property.getMin();
//        String max = property.getMax();
//        if (StringUtils.hasText(min) && value.length() < Integer.parseInt(min)) {
//            errors.add(SpringAppContextUtil.getMessage("validation.min_length_error", name, value.length(), min));
//            return false;
//        }
//        if (StringUtils.hasText(max) && value.length() > Integer.parseInt(max)) {
//            errors.add(SpringAppContextUtil.getMessage("validation.max_length_error", name, value.length(), min));
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateBoolean(ModelPropertyBean property, String name, Object value) {
//
//        if (value == null || !(value instanceof Boolean)) {
//            try {
//                Boolean val = (value == null) ? false : BooleanUtils.toBooleanObject((String) value);
////				if(val == null) 
////				{
////					errors.add(SpringAppContextUtil.getMessage("validation.invalid_bool_error", name, value));
////					return false;
////				}
//                obj.setBoolean(name, val);
//            } catch (IllegalArgumentException e) {
//                errors.add(SpringAppContextUtil.getMessage("validation.invalid_bool_error", name, value));
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean validateLong(ModelPropertyBean property, String name, Object value) {
//        LongValidator validator = LongValidator.getInstance();
//        Long longVal = null;
//        String min = property.getMin();
//        String max = property.getMax();
//        if (value instanceof Long) {
//            longVal = (Long) value;
//        } else if (value instanceof Integer) {
//            longVal = ((Integer) value).longValue();
//        } else {
//            String strVal = (String) value;
//            longVal = validator.validate(strVal);
//            if (longVal == null) {
//                errors.add(SpringAppContextUtil.getMessage("validation.invalid_long_error", name, value));
//                return false;
//            }
//            obj.setLong(name, longVal);
//        }
//        if (StringUtils.hasText(min) && !validator.minValue(longVal, Long.parseLong(min))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.min_value_error", name, value, min));
//            return false;
//        }
//        if (StringUtils.hasText(max) && !validator.maxValue(longVal, Long.parseLong(max))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.max_value_error", name, value, min));
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateInteger(ModelPropertyBean property, String name, Object value) {
//        IntegerValidator validator = IntegerValidator.getInstance();
//        Integer intVal = null;
//        String min = property.getMin();
//        String max = property.getMax();
//        if (value instanceof Integer) {
//            intVal = (Integer) value;
//        } else if (value instanceof Long) {
//            intVal = ((Long) value).intValue();
//        } else {
//            String strVal = (String) value;
//            intVal = validator.validate(strVal);
//            if (intVal == null) {
//                errors.add(SpringAppContextUtil.getMessage("validation.invalid_int_error", name, value));
//                return false;
//            }
//            obj.setInteger(name, intVal);
//        }
//        if (StringUtils.hasText(min) && !validator.minValue(intVal, Integer.parseInt(min))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.min_value_error", name, value, min));
//            return false;
//        }
//        if (StringUtils.hasText(max) && !validator.maxValue(intVal, Integer.parseInt(max))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.max_value_error", name, value, max));
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateDecimal(ModelPropertyBean property, String name, Object value) {
//        BigDecimal decimalVal = null;
//        BigDecimalValidator validator = BigDecimalValidator.getInstance();
//        String min = property.getMin();
//        String max = property.getMax();
//        if (value instanceof BigDecimal) {
//            decimalVal = (BigDecimal) value;
//        } else if (value instanceof Double) {
//            decimalVal = new BigDecimal((Double) value);
//        } else if (value instanceof Integer) {
//            decimalVal = new BigDecimal((Integer) value);
//        } else if (value instanceof Long) {
//            decimalVal = new BigDecimal(((Long) value).intValue());
//        } else {
//            String strVal = (String) value;
//            decimalVal = validator.validate(strVal);
//            if (decimalVal == null) {
//                errors.add(SpringAppContextUtil.getMessage("validation.invalid_decimal_error", name, value));
//                return false;
//            }
//            obj.setDecimal(name, decimalVal);
//        }
//        if (StringUtils.hasText(min) && !validator.minValue(decimalVal, Double.parseDouble(min))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.min_value_error", name, value, min));
//            return false;
//        }
//        if (StringUtils.hasText(max) && !validator.maxValue(decimalVal, Double.parseDouble(max))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.max_value_error", name, value, min));
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateDate(ModelPropertyBean property, String name, Object value) {
//        Date dateVal = null;
//        String min = property.getMin();
//        String max = property.getMax();
//        CalendarValidator validator = CalendarValidator.getInstance();
//        if (value instanceof Date) {
//            dateVal = (Date) value;
//        } else {
//            String strVal = value.toString();
//            Calendar c = validator.validate(strVal, DEFAULT_DATE_FORMAT);
//            if (c == null) {
//                c = validator.validate(strVal, DEFAULT_TIME_FORMAT);
//                if (c == null) {
//                    errors.add(SpringAppContextUtil.getMessage("validation.invalid_date_error", name, value));
//                    return false;
//                }
//            }
//            dateVal = c.getTime();
//            obj.setDate(name, dateVal);
//        }
//        if (StringUtils.hasText(min) && dateVal.before(DateUtils.stringToDate(min, DEFAULT_DATE_FORMAT))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.min_value_error", name, value, min));
//            return false;
//        }
//        if (StringUtils.hasText(max) && dateVal.after(DateUtils.stringToDate(max, DEFAULT_DATE_FORMAT))) {
//            errors.add(SpringAppContextUtil.getMessage("validation.max_value_error", name, value, min));
//            return false;
//        }
//        return true;
//    }

    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_PROPERTY = "date";
    public static final String BOOLEAN_PROPERTY = "boolean";
    public static final String DECIMAL_PROPERTY = "decimal";
    public static final String INTEGER_PROPERTY = "integer";
    public static final String LONG_PROPERTY = "long";
    public static final String STRING_PROPERTY = "string";
    public static final String BLOB_PROPERTY = "blob";

    public static final String ID_SYS_PROPERTY = "id";
    public static final String USER_ID_SYS_PROPERTY = "user_id";
    public static final String USER_TYPE_SYS_PROPERTY = "user_type";
    public static final String ORG_SYS_PROPERTY = "org";
    public static final String CREATED_AT_SYS_PROPERTY = "created_at";
    public static final String MODIFIED_AT_SYS_PROPERTY = "modified_at";
    public static final String CREATED_BY_SYS_PROPERTY = "created_by";
    public static final String MODIFIED_BY_SYS_PROPERTY = "modified_by";
    public static final String CREATED_BY_NAME_PROPERTY = "created_by_name";
    public static final String MODIFIED_BY_NAME_PROPERTY = "modified_by_name";
    public static final String MODEL_SYS_PROPERTY = "model";
    public static final String NOW_SYS_PROPERTY = "_now";

    public static final String AUTH_USER_TYPE_PROPERTY = "auth_user_type";
    public static final String AUTH_USER_ID_PROPERTY = "auth_user_id";
    public static final String AUTH_ORG_PROPERTY = "auth_org";

    private List<String> errors;
//    private Map<String, ModelPropertyBean> properties;
//    private ObjectBean obj;

}
