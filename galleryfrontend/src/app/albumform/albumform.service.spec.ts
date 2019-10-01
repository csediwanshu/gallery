import { TestBed } from '@angular/core/testing';

import { AlbumformService } from './albumform.service';

describe('AlbumformService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AlbumformService = TestBed.get(AlbumformService);
    expect(service).toBeTruthy();
  });
});
