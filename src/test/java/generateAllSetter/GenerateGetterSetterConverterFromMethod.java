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

package generateAllSetter;

import com.bruce.intellijplugin.generatesetter.CommonConstants;
import com.intellij.codeInsight.intention.IntentionAction;
import org.assertj.core.api.Assertions;

/**
 * @author bruce ge
 */
public class GenerateGetterSetterConverterFromMethod extends BaseTest {
    public void testConverter() {
        myFixture.configureByText("Article.java", loadBeforeFile(GenerateGetterSetterConverterFromMethod.class, "before/Article.java"));

        IntentionAction singleIntention = myFixture.findSingleIntention(CommonConstants.GENERATE_GETTER_SETTER_CONVERTER_FROM_METHOD);

        Assertions.assertThat(singleIntention).isNotNull();
        myFixture.launchAction(singleIntention);

        myFixture.checkResultByFile("after/ArticleUsingSetterGetter.java",true);
    }
 }
