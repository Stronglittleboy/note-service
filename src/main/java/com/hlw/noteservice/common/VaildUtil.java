package com.hlw.noteservice.common;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;

public class VaildUtil {
    private static Validator validator = new Validator();

    /**
     * 实体校验
     *
     * @param t
     * @param <T>
     */
    public static <T> void vaildBean(T t){
        List<ConstraintViolation> validate = validator.validate(t);
        if (!validate.isEmpty()){
            throw new BusinessException(validate.get(0).getMessage());
        }
    }
}
