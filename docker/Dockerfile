FROM clojure:openjdk-11-lein-slim-buster

MAINTAINER Yury Antonov <yantonov@yandex.ru>

ENV \
    WORK_DIR=/workspace \
    PYTHON_TEMPLATE_LEIN_PLUGIN_URL=https://github.com/yantonov/python-library-template.git

RUN mkdir -p /workspace && \
    apt-get update && \
    apt-get install -y git && \
    mkdir -p /opt/ && \
    cd /opt && \
    git clone ${PYTHON_TEMPLATE_LEIN_PLUGIN_URL} python-library-template && \
    cd python-library-template && \
    lein install

WORKDIR $WORK_DIR
