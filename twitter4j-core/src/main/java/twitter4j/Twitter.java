/*
 * Copyright 2007 Yusuke Yamamoto
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
package twitter4j;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.0
 */
@SuppressWarnings("unused")
public interface Twitter extends java.io.Serializable {

    /**
     * returns new Builder instance
     *
     * @return Builder instance
     */
    static TwitterBuilder newBuilder() {
        return new TwitterBuilder();
    }

    /**
     * equivalent to calling newBuilder().build();
     *
     * @return Twitter Instance
     */
    static Twitter getInstance() {
        return newBuilder().build();
    }

    /**
     * @return returns Twitter API v1.1 interfaces
     */
    TwitterV1 v1();





    /**
     * builder for Twitter
     */
    class TwitterBuilder extends Configuration<TwitterBuilder> {
        private TwitterBuilder() {
        }

        /**
         * @return constructs Twitter instance
         */
        public Twitter build() {
            return new TwitterImpl(buildConfiguration());
        }
    }
}
