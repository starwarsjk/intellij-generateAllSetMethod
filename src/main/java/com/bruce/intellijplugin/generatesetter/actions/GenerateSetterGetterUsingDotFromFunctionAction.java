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
public class GenerateSetterGetterUsingDotFromFunctionAction extends GenerateAllSetterBase {
    public GenerateSetterGetterUsingDotFromFunctionAction() {
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
        return CommonConstants.GENERATE_GETTER_SETTER_USING_DOT_CONVERTER_FROM_METHOD;
    }

    @Override
    protected String generateBegin(String splitText, String className, String variableName) {
        return splitText + "return new " + className + "()";
    }

    @Override
    protected String modifySetterLine(String setterLine) {
        String toBegin = setterLine.substring(setterLine.indexOf("."));
        String prawieBegin = toBegin.substring(4);

        String lowerCased = prawieBegin.substring(0, 1).toLowerCase();
        String dobryBegin = prawieBegin.substring(1);
        String prawieDobryNapis = dobryBegin.substring(0, dobryBegin.length() - 1);
        return "        ." + lowerCased + prawieDobryNapis;
    }

    @Override
    protected String generateEnding(String insertText, String variableName) {
        int indexOfLastBracket = insertText.lastIndexOf(")") + 1;
        return insertText.substring(0, indexOfLastBracket) + ";";
    }
}
