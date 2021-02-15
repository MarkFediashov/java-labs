/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.mavenproject1;

import java.net.InetAddress;

/**
 *
 * @author User
 */
 public class Address {
        
        public Address(InetAddress inet, int port) {
            host = inet;
            this.port = port;
        }

        public InetAddress getHost() {
            return host;
        }

        public void setHost(InetAddress host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
        public InetAddress host;
        public int port;
    }
