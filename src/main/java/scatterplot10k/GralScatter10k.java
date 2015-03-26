/*
 * Copyright 2015 deric.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package scatterplot10k;

import scatterplot1k.GralScatter;

/**
 *
 * @author deric
 */
public class GralScatter10k extends GralScatter {

    public GralScatter10k(int sampleCount) {
        super(sampleCount);
    }

    public static void main(String[] args) {
        plot(10000);
    }

}
