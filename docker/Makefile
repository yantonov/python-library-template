help:
	@cat Makefile

DOCKER_FILE=Dockerfile
SRC?=$(shell pwd)
CONTAINER_DIR=/workspace
PROJECT_DIR?=new-awesome-project

IMAGE=yantonov/python-library-template
CONTAINER_NAME?=$(shell echo "$(IMAGE)" | tr '/' '_')

build:
	docker build \
		-t $(IMAGE) \
		-f $(DOCKER_FILE) .

run:
	docker run \
			-i -t \
			--name "$(CONTAINER_NAME)" \
			-v "$(SRC):$(CONTAINER_DIR)" \
			--rm \
			"$(IMAGE)" \
			lein new python-library "$(PROJECT_DIR)" --snapshot

ssh:
	docker run --rm -t -i -v "$(SRC):$(CONTAINER_DIR)" "$(IMAGE)" /bin/bash

stop:
	docker stop "$(CONTAINER_NAME)"

pull:
	docker pull "$(IMAGE)"

uninstall:
	docker image rm "$(IMAGE)"
