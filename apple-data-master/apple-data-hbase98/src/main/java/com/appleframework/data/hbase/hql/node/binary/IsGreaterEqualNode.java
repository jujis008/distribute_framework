package com.appleframework.data.hbase.hql.node.binary;

import java.util.Map;

import com.appleframework.data.hbase.config.SimpleHbaseRuntimeSetting;

import com.appleframework.data.hbase.hql.HQLNodeType;
import com.appleframework.data.hbase.util.CompareUtil;

/**
 * @author xinzhi
 */
public class IsGreaterEqualNode extends BinaryNode {

    protected IsGreaterEqualNode() {
        super(HQLNodeType.IsGreaterEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = runtimeSetting.interpret(
                propertyObject.getClass(), getCompareValue());
        return CompareUtil.compare(propertyObject, compareObject) >= 0;
    }
}
