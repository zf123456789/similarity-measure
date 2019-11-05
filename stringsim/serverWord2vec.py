import gensim.models.keyedvectors as word2vec
import numpy as np
import socket
import sys


model=word2vec.KeyedVectors.load_word2vec_format('./GoogleNews-vectors-negative300.bin',binary=True)


# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 10004)
print (sys.stderr, 'starting up on %s port %s' % server_address)
sock.bind(server_address)
sock.listen(1)

while True:
    # Wait for a connection
    #print (sys.stderr, 'waiting for a connection')
    connection, client_address = sock.accept()
    try:
        #print (sys.stderr, 'connection from', client_address)

        # Receive the data in small chunks and retransmit it
        while True:
            data = connection.recv(1001)
            #print (sys.stderr, 'received ', data)
            if data:
                #print (sys.stderr, 'sending data back to the client')
                data = data.decode("utf-8") 
                words = data.split(',')
                if words[0]==words[1]:
                    result=1
                else:
                    try:
                        result=model.similarity(words[0],words[1])
                    except KeyError:
                        result=0
                result = str(result) + "\n"
                #print(str(result))
                connection.sendall(bytes(result, "utf-8"))
            else:
                #print (sys.stderr, 'no more data from', client_address)
                break
            
    finally:
        # Clean up the connection
        connection.close()