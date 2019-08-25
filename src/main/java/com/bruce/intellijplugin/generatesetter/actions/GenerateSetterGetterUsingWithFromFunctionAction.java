/*
 *  Copyright (c) 2017-2019, bruce.ge.
 *    This program is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU General Public License
 *    as published by the Free Software Foundation; version 2 of
 *    the License.
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *    GNU General Public License for more details.
 *    You should have received a copy of the GNU General Public License
 *    along with this program;
 */

package com.bruce.intellijplugin.generatesetter.actions;

import com.bruce.intellijplugin.generatesetter.CommonConstants;
import com.bruce.intellijplugin.generatesetter.GenerateAllHandlerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * @author bruce ge
 */
public class GenerateSetterGetterUsingWithFromFunctionAction extends GenerateAllSetterBase {
    public GenerateSetterGetterUsingWithFromFunctionAction() {
        super(new GenerateAllHandlerAdapter() {
            @Override
            public boolean isFromMethod() {
                return true;
            }
        });
    }


    @NotNull
    @Override
    public String getText() {
        return CommonConstants.GENERATE_GETTER_SETTER_USING_WITH_CONVERTER_FROM_METHOD;
    }

    @Override
    protected String generateBegin(String splitText, String className, String variableName) {
        return splitText + "return new " + className + "()";
    }

    @Override
    protected String modifySetterLine(String setterLine) {
        String toBegin = setterLine.substring(setterLine.indexOf("."));
        return "        .with" + toBegin.substring(4, toBegin.length() - 1);
    }

    @Override
    protected String generateEnding(String insertText, String variableName) {
        int indexOfLastBracket = insertText.lastIndexOf(")") + 1;
        return insertText.substring(0, indexOfLastBracket) + ";";
    }
}
